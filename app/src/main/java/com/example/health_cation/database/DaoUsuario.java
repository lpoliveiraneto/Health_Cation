package com.example.health_cation.database;

import android.support.annotation.Nullable;

import com.example.health_cation.model.User;

import java.util.ArrayList;
import java.util.List;

public class DaoUsuario {
    private final static List<User> users = new ArrayList<>();
    private static int contadorDeIds = 1;

    public void remove(User user) {
        User userDevolvido = buscaUserPeloId(user);
        if(userDevolvido != null){
            users.remove(userDevolvido);
        }
    }

    public void salvar(User user) {
        user.setId(contadorDeIds);
        users.add(user);
        atualizaIds();
    }

    private void atualizaIds() {
        contadorDeIds++;
    }

    public void edita(User user) {
        User userEncontrado = buscaUserPeloId(user);
        if (userEncontrado != null) {
            int posicaodoAluno = users.indexOf(userEncontrado);
            users.set(posicaodoAluno, user);
        }
    }
    @Nullable
    private User buscaUserPeloId(User user) {
        for (User u :
                users) {
            if (u.getId() == user.getId()) {
                return u;
            }
        }
        return null;
    }

}
