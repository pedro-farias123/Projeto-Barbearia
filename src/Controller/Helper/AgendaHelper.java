/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Helper;

import Model.Agendamento;
import Model.Cliente;
import static Model.DAO.Banco.servico;
import Model.Servico;
import View.Agenda;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author marce
 */
public class AgendaHelper {
    
    private final Agenda view;

    public AgendaHelper(Agenda view) {
        this.view = view;
    }

    /**
     *
     * @param agendamentos
     */
    public void preencherTabela(ArrayList<Agendamento> agendamentos) {
        
        DefaultTableModel tabbleModel = (DefaultTableModel) view.getTableAgendamentos().getModel();
        tableModel.setNumRows(0);
        
        // Percorrer a lista preenchendo o table model
        agendamentos.forEach((agendamento) -> {
            tableModel.addRow( new Object[] {
                
                agendamento.getId(),
                agendamento.getCliente().getNome(),
                agendamento.getServico().getDescricao(),
                agendamento.getValor(),
                agendamento.getDataFormatada(),
                agendamento.getHoraFormatada(),
                agendamento.getObservacao()              
            });
        });
        
        
        
}

    public void preencherClientes(ArrayList<Cliente> clientes) {
       
        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) view.getTextCliente().getModel();
       
        clientes.forEach((cliente) -> {
            comboBoxModel.addElement(cliente); //aqui está o truque
        });
    }

    public void preencherServicos(ArrayList<Servico> servicos) {
      
        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) view.getTextServico().getModel();
        
        servicos.forEach((_item) -> {
            comboBoxModel.addElement(servico);
        });
        
    }

    public Servico obterServico() {
        return (Servico)  view.getTextServico().getSelectedItem();
       
    }

    public void setarValor(float valor) {
        view.getTextValor().setText(valor+""); 
    }
    

    

    
    

    private static class tableModel {

        private static void addRow(Object[] object) {
            
        }

        private static void setNumRows(int i) {
           
        }

        public tableModel() {
        }
    }

    
    
    
}
