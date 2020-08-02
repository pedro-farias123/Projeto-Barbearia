/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.Helper.LoginHelper;
import Model.DAO.UsuarioDAO;
import Model.Usuario;
import View.Login;
import View.MenuPrincipal;

/**
 *
 * @author marce
 */
public class LoginController {

    private final Login view;
    private LoginHelper helper;

    public LoginController(Login view) {
        this.view = view;
        this.helper = new LoginHelper(view);
    }
    
    
    
    
    
    public void entrarNoSistema(){
        
        //Pegar um Usuário da View
        Usuario usuario =  helper.obterModelo();
        
        
        //Pesquisa o Usuário no Banco
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuarioAutenticado = usuarioDAO.selectPorNomeESenha(usuario);
        
         //Se o usuário da view tiver o mesmo usuario e senha que o usuario vindo do banco, direcionar para o menu principal
        //Senão, mostrar uma mensagem ao usario "Usuário ou senha inválidos"
        if(usuarioAutenticado != null){
                MenuPrincipal menu = new MenuPrincipal();
                menu.setVisible(true);
                this.view.dispose();
        } else{
            view.exibeMensagem("Usuario ou senha invalidos");
        }
   
    }
    
    public void fizTarefa(){
        System.out.println("Busquei algo do banco de dados");
        
        this.view.exibeMensagem("Executei o fiz tarefa");
    }
    
    
}
