package com.controle.notebooks.Service;

import com.controle.notebooks.Model.M_Usuario;
import com.controle.notebooks.Repository.R_Usuario;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class S_Usuario {
    private static R_Usuario r_usuario;

    public S_Usuario(R_Usuario r_usuario) {
        this.r_usuario =  r_usuario;
    }

    public static M_Usuario verificaLogin(String nome, String senha){

        if(S_Generico.textoEstaVazio(nome)){
            return null;
        }else if(S_Generico.textoEstaVazio(senha)){
            return null;
        }
        return r_usuario.buscarPornomeSenha((nome),senha);
    }

    public static String cadastrarUsuario(String nome, Date data_nascimento, String CPF, String RG, String numero_celular, String email,String CEP, String cidade,  String estado, String senha){
        boolean podeSalvar = true;
        String mensagem = "";

        if(S_Generico.textoEstaVazio(nome)){
            podeSalvar = false;
            mensagem += "O nome precisa ser preenchido!";
        }
        if(!S_Generico.validarEmail(email)){
            podeSalvar = false;
            mensagem += "e-Mail inválido!";
        }
        if(S_Generico.textoEstaVazio(String.valueOf(data_nascimento))){
            podeSalvar = false;
            mensagem += "A data_nascimento precisa ser informada!";
        }
        if(S_Generico.textoEstaVazio(String.valueOf(CPF))){
            podeSalvar = false;
            mensagem += "O CPF deve ser selecionado!";
        }
        if(S_Generico.textoEstaVazio(String.valueOf(RG))){
            podeSalvar = false;
            mensagem += "O RG deve ser selecionado!";
        }
        if(S_Generico.textoEstaVazio(String.valueOf(numero_celular))){
            podeSalvar = false;
            mensagem += "O numero_celular deve ser selecionado!";
        }
        if(S_Generico.textoEstaVazio(String.valueOf(CEP))){
            podeSalvar = false;
            mensagem += "O CEP deve ser selecionado!";
        }if(S_Generico.textoEstaVazio(String.valueOf(cidade))){
            podeSalvar = false;
            mensagem += "O cidade deve ser selecionado!";
        }
        if(S_Generico.textoEstaVazio(String.valueOf(estado))){
            podeSalvar = false;
            mensagem += "O estado deve ser selecionado!";
        }
        if(S_Generico.textoEstaVazio(String.valueOf(senha))){
            podeSalvar = false;
            mensagem += "O senha deve ser selecionado!";
        }


        if(podeSalvar){
            M_Usuario m_usuario = new M_Usuario();
            m_usuario.setNome(nome);
            m_usuario.setEmail(email);
            m_usuario.setData_nascimento(data_nascimento);
            m_usuario.setCPF(CPF);
            m_usuario.setRG(RG);
            m_usuario.setNumero_celular(numero_celular);
            m_usuario.setCEP(CEP);
            m_usuario.setCidade(cidade);
            m_usuario.setEstado(estado);
            m_usuario.setSenha(senha);

            try{
                r_usuario.save(m_usuario);
                mensagem += "Deu Bom";
            }catch (DataIntegrityViolationException e){
                mensagem += "Deu Ruim";
            }
        }
        return mensagem;
    }
}