package com.controle.notebooks.Controller;

import com.controle.notebooks.Service.S_Usuario;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Date;


@Controller
public class C_Usuario {
        @GetMapping("/")
        public String getLogin(HttpSession session){
            if(session.getAttribute("nome") != null) {
                return "redirect:/home";
            }else{
                return "index";
            }
        }

    @PostMapping("/login")
    @ResponseBody
    public boolean postLogin(@RequestParam("nome") String nome,
                             @RequestParam("senha") String senha,
                             HttpSession session){
        session.setAttribute("nome", S_Usuario.verificaLogin(nome, senha));
        if(session.getAttribute("nome") == null){
            return false;
        }else{
            return true;
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.setAttribute("usuario", null);
        return "redirect:/";
    }

    @GetMapping("/cadastro")
    public String getCadastro(){
        return "usuario/cadastro";
    }

    @PostMapping("/cadastro")
    @ResponseBody
    public String cadastrarUsuario(@RequestParam("nome") String nome,
                                   @RequestParam("data_nascimento") Date data_nascimento,
                                   @RequestParam("CPF") String CPF,
                                   @RequestParam("RG") String RG,
                                   @RequestParam("numero_celular") String numero_celular,
                                   @RequestParam("email") String email,
                                   @RequestParam("CEP") String CEP,
                                   @RequestParam("cidade") String cidade,
                                   @RequestParam("estado")  String estado,
                                   @RequestParam("senha") String senha){

        S_Usuario.cadastrarUsuario(nome,data_nascimento,CPF,RG,numero_celular,email,CEP,cidade,estado,senha);

        return "usuario/cadastro";
    }

}
