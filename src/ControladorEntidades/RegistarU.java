/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladorEntidades;

import Controlador.UsuarioJpaController;
import Modelo.Usuario;
import javax.swing.JOptionPane;
import static Vista.ModificarDatos.jCAnio;
import static Vista.ModificarDatos.jCDia;
import static Vista.ModificarDatos.jCMes;
import static Vista.ModificarDatos.jTextApelli;
import static Vista.ModificarDatos.jTextCorr;
import static Vista.ModificarDatos.jTextNom;
import static Vista.ModificarDatos.jTextTele;
import Vista.PerfilU;
import static Vista.PerfilU.TextApellido;
import static Vista.PerfilU.TextCedula;
import static Vista.PerfilU.TextCorreo;
import static Vista.PerfilU.TextNombre;
import static Vista.PerfilU.TextTelefono;
import static Vista.RegistrarUsuario.jComboAnio;
import static Vista.RegistrarUsuario.jComboDia;
import static Vista.RegistrarUsuario.jComboMes;
import static Vista.RegistrarUsuario.jTextApellidos;
import static Vista.RegistrarUsuario.jTextCedula;
import static Vista.RegistrarUsuario.jTextCorreo;
import static Vista.RegistrarUsuario.jTextDireccion;
import static Vista.RegistrarUsuario.jTextNombre;
import static Vista.RegistrarUsuario.jTextTelefono;


/**
 *
 * @author Andres R
 */
public class RegistarU {
    UsuarioJpaController CUsuar = new UsuarioJpaController();
    Usuario us = new Usuario();
    Usuario edi ;
    PerfilU perfil = new PerfilU();
    public void registrarUsu() {

        if (jComboDia.getSelectedItem().toString() == "Dia" || jComboMes.getSelectedItem().toString() == "Mes"
                || jComboAnio.getSelectedItem().toString() == "Año") {
            JOptionPane.showMessageDialog(null, "Seleccione la fecha de nacimiento correcta");
            
        } else {
            try {
                us.setApellidos(jTextApellidos.getText());
                us.setCedula(jTextCedula.getText());
                us.setCorreo(jTextCorreo.getText());
                us.setDireccion(jTextDireccion.getText());
                us.setNombres(jTextNombre.getText());
                us.setTelefono(jTextTelefono.getText());
                if (jTextApellidos.getText().isEmpty() || jTextCedula.getText().isEmpty() || jTextCorreo.getText().isEmpty()
                        || jTextDireccion.getText().isEmpty() || jTextNombre.getText().isEmpty() || jTextTelefono.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Ingrese todos los campos");
                } else {
                    TextNombre.setText(jTextNombre.getText());
                    TextApellido.setText(jTextApellidos.getText());
                    TextCedula.setText(jTextCedula.getText());
                    TextCorreo.setText(jTextCorreo.getText());
                    TextTelefono.setText(jTextTelefono.getText());
                    CUsuar.create(us);
                    JOptionPane.showMessageDialog(null, "Se ha registro con exito");
                    perfil.setVisible(true);
                    

                }

            } catch (Exception e) {
                System.out.println(e);
                JOptionPane.showMessageDialog(null, "No se realizo el registro con exito");
            }

        }

    }

    public void modiUsu() {
        if (jCDia.getSelectedItem().toString() == "Dia" || jCMes.getSelectedItem().toString() == "Mes"
                || jCAnio.getSelectedItem().toString() == "Año") {
            JOptionPane.showMessageDialog(null, "Seleccione la fecha de nacimiento correcta");
        } else {
            try {
                edi = CUsuar.findUsuarios(Integer.toUnsignedLong(1));
                edi.setNombres(jTextNom.getText());
                edi.setApellidos(jTextApelli.getText());
                edi.setCorreo(jTextCorr.getText());
                edi.setTelefono(jTextTele.getText());
                edi.setCedula(jTextCedula.getText());
                edi.setDireccion(jTextDireccion.getText());

                if (jTextNom.getText().isEmpty() || jTextApelli.getText().isEmpty() || jTextCorr.getText().isEmpty()
                        || jTextTele.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Ingrese todos los campos");

                } else {
                    TextNombre.setText(jTextNom.getText());
                    TextApellido.setText(jTextApelli.getText());
                    TextCorreo.setText(jTextCorr.getText());
                    TextTelefono.setText(jTextTele.getText());
                    TextCedula.setText(jTextCedula.getText());
                    CUsuar.edit(edi);
                    JOptionPane.showMessageDialog(null, "Se ha guardado con exito");
                    
                   
                    perfil.setVisible(true);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "No se realizo el guardado");
                JOptionPane.showMessageDialog(null, e);
            }
        }

    }

}
