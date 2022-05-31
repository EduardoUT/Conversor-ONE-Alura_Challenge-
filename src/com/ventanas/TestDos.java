/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ventanas;

import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JOptionPane;
import com.clases.divisa.PesoMexicano;
import com.clases.temperatura.Temperatura;
import java.math.BigDecimal;
import jdk.nashorn.internal.runtime.JSType;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author mcore
 */
public class TestDos {

    public static void main(String[] args) throws
            ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        //Configurando apariencia de las ventanas emergentes.
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        UIManager.put("OptionPane.background", Color.DARK_GRAY);
        UIManager.put("OptionPane.messageForeground", Color.WHITE);
        UIManager.put("Panel.background", Color.DARK_GRAY);
        UIManager.put("Button.background", Color.DARK_GRAY);
        UIManager.put("ComboBox.background", Color.DARK_GRAY);
        UIManager.put("ComboBox.selectionForeground", Color.WHITE);
        UIManager.put("ComboBox.background", new Color(126, 193, 228));
        menuPrincipal(); // <---- Buscar método Runnable para hacer JAR File. 
    }

    public static void menuPrincipal() {
        //Creando ventana menú con ComboBox de dos opciones.
        Object seleccionTipoConversion = JOptionPane.showInputDialog(
                null,
                "Seleccione una opción de conversión: ",
                "Menú",
                JOptionPane.QUESTION_MESSAGE,
                null,
                new Object[]{
                    "Conversor de Moneda",
                    "Conversor de Temperatura"
                },
                "Conversor de Moneda" //Opción seleccionada por defecto.
        );

        //Si el usuario no presiona Cancel o el botón cerrar "X".
        if (seleccionTipoConversion != null) {
            if (esConversorMoneda(seleccionTipoConversion)) {
                conversionDivisaUsuario();
            } else {
                conversorTemperatura();
            }
        } else {
            System.exit(0);
        }
    }

    /**
     * Llama a la ventana de ingreso de valor a convertir en divisa.
     */
    public static void conversionDivisaUsuario() {
        String valorUsuario = JOptionPane.showInputDialog(
                null,
                "Ingresa la cantidad de dinero que deseas convertir: ",
                "Cantidad a Convertir",
                JOptionPane.QUESTION_MESSAGE
        );

        if (valorUsuario != null) {
            try {
                double valorUsuarioToDouble = Double.valueOf(valorUsuario);
                esNumerico(valorUsuarioToDouble);
                String valorSeleccionTipoDivisa;
                //Instanciando la clase que contiene todos los métodos para conversión.
                PesoMexicano pesoMexicano = new PesoMexicano();
                double tasaCambio;
                Object seleccionTipoDivisa = JOptionPane.showInputDialog(
                        null,
                        "Elije la moneda a la que desea convertir tu dinero: ",
                        "Tipo de Moneda",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        new Object[]{
                            "Peso Mexicano (MXN) a Dólar Américano (USD)",
                            "Peso Mexicano (MXN) a Euro (EUR)",
                            "Peso Mexicano (MXN) a Libra Esterlina (GBP)",
                            "Peso Mexicano (MXN) a Yen (JPY)",
                            "Peso Mexicano (MXN) a Won Coreano (KRW)",
                            "Dólar Americano (USD) a Peso Mexicano (MXN)",
                            "Euro (EUR) a Peso Mexicano (MXN)",
                            "Libra Exterlina (GBP) a Peso Mexicano (MXN)",
                            "Yen (JPY) a Peso Mexicano (MXN)",
                            "Won Coreano (KRW) a Peso Mexicano (MXN)"
                        },
                        "Peso Mexicano (MXN) a Dólar Américano (USD)"
                );

                if (seleccionTipoDivisa != null) {
                    valorSeleccionTipoDivisa = seleccionTipoDivisa.toString();
                    switch (valorSeleccionTipoDivisa) {
                        case "Peso Mexicano (MXN) a Dólar Américano (USD)":
                            tasaCambio = pesoMexicano.getTasaCambioDolarAmericano();
                            pesoMexicano.conversionDivisa(tasaCambio, valorUsuarioToDouble, valorSeleccionTipoDivisa);
                            break;
                        case "Peso Mexicano (MXN) a Euro (EUR)":
                            tasaCambio = pesoMexicano.getTasaCambioEuros();
                            pesoMexicano.conversionDivisa(tasaCambio, valorUsuarioToDouble, valorSeleccionTipoDivisa);
                            break;
                        case "Peso Mexicano (MXN) a Libra Esterlina (GBP)":
                            tasaCambio = pesoMexicano.getTasaCambioLibrasEsterlinas();
                            pesoMexicano.conversionDivisa(tasaCambio, valorUsuarioToDouble, valorSeleccionTipoDivisa);
                            break;
                        case "Peso Mexicano (MXN) a Yen (JPY)":
                            tasaCambio = pesoMexicano.getTasaCambioYenJapones();
                            pesoMexicano.conversionDivisa(tasaCambio, valorUsuarioToDouble, valorSeleccionTipoDivisa);
                            break;
                        case "Peso Mexicano (MXN) a Won Coreano (KRW)":
                            tasaCambio = pesoMexicano.getTasaCambioWonSurCoreano();
                            pesoMexicano.conversionDivisa(tasaCambio, valorUsuarioToDouble, valorSeleccionTipoDivisa);
                            break;
                        case "Dólar Americano (USD) a Peso Mexicano (MXN)":
                            tasaCambio = pesoMexicano.getTasaCambioDolarAmericano();
                            pesoMexicano.conversionDivisa(tasaCambio, valorUsuarioToDouble, valorSeleccionTipoDivisa);
                            break;
                        case "Euro (EUR) a Peso Mexicano (MXN)":
                            tasaCambio = pesoMexicano.getTasaCambioEuros();
                            pesoMexicano.conversionDivisa(tasaCambio, valorUsuarioToDouble, valorSeleccionTipoDivisa);
                            break;
                        case "Libra Exterlina (GBP) a Peso Mexicano (MXN)":
                            tasaCambio = pesoMexicano.getTasaCambioLibrasEsterlinas();
                            pesoMexicano.conversionDivisa(tasaCambio, valorUsuarioToDouble, valorSeleccionTipoDivisa);
                            break;
                        case "Yen (JPY) a Peso Mexicano (MXN)":
                            tasaCambio = pesoMexicano.getTasaCambioYenJapones();
                            pesoMexicano.conversionDivisa(tasaCambio, valorUsuarioToDouble, valorSeleccionTipoDivisa);
                            break;
                        case "Won Coreano (KRW) a Peso Mexicano (MXN)":
                            tasaCambio = pesoMexicano.getTasaCambioWonSurCoreano();
                            pesoMexicano.conversionDivisa(tasaCambio, valorUsuarioToDouble, valorSeleccionTipoDivisa);
                            break;
                        default:
                            break;
                    }
                    mensajeDeseaContinuarDivisa();
                } else {
                    menuPrincipal();
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(
                        null,
                        "El valor ingresado no es un número entero o decimal",
                        "Error al recibir los datos.",
                        JOptionPane.ERROR_MESSAGE
                );
                /**
                 * Con recursividad volvemos a pedir el valor llamando la
                 * ventana si no es numérico.
                 */
                conversionDivisaUsuario();
            }
        } else {
            System.exit(0);
        }
    }

    /**
     * Llama a la ventana de conversión de temperaturas.
     */
    public static void conversorTemperatura() {
        String valorUsuario = JOptionPane.showInputDialog(
                null,
                "Ingresa el valor de Temperatura que deseas convertir: ",
                "Cantidad de Temperatura a Convertir",
                JOptionPane.QUESTION_MESSAGE
        );

        if (valorUsuario != null) {
            try {
                double valorUsuarioToDouble = Double.valueOf(valorUsuario);
                esNumerico(valorUsuarioToDouble);
                String valorSeleccionTipoTemperatura;
                Temperatura t = new Temperatura();
                BigDecimal bd = new BigDecimal(String.valueOf(valorUsuarioToDouble));

                Object seleccionTipoTemperatura = JOptionPane.showInputDialog(
                        null,
                        "Elije el tipo de conversión de temperatura que deseas hacer: ",
                        "Selección conversiones de Temperatura",
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        new Object[]{
                            "Celcius (°C) a Farenheit (°F)",
                            "Celcius (°C) a Kelvin (°K)",
                            "Farenheit (°F) a Celsius (°C)",
                            "Farenheit (°F) a Kelvin (°K)",
                            "Kelvin (°K) a Celsius (°C)",
                            "Kelvin (°K) a Farenheit (°F)"
                        },
                        "Celcius (°C) a Farenheit (°F)"
                );
                valorSeleccionTipoTemperatura = seleccionTipoTemperatura.toString();
                t.convertirTemperatura(bd, valorSeleccionTipoTemperatura);
                mensajeDeseaContinuarTemperatura();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(
                        null,
                        "El valor ingresado no es un número entero o decimal",
                        "Error al recibir los datos.",
                        JOptionPane.ERROR_MESSAGE
                );
                conversorTemperatura();
            }

        } else {
            System.exit(0);
        }

    }

    public static void mensajeDeseaContinuarDivisa() {
        int seleccionUsuario = JOptionPane.showOptionDialog(
                null,
                "¿Desea realizar otra conversión de divisa?",
                "Selector de opciones",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new Object[]{
                    "Sí",
                    "No, ir al menú principal",
                    "Salir"
                },
                "Sí"
        );

        if (seleccionUsuario != -1) {
            switch (seleccionUsuario) {
                case 0:
                    conversionDivisaUsuario();
                    break;
                case 1:
                    menuPrincipal();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Programa finalizado :D");
                    break;
            }
        } else {
            System.exit(0);
        }
    }

    public static void mensajeDeseaContinuarTemperatura() {
        int seleccionUsuario = JOptionPane.showOptionDialog(
                null,
                "¿Desea realizar otra conversión de temperatura?",
                "Selector de opciones",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new Object[]{
                    "Sí",
                    "No, ir al menú principal",
                    "Salir"
                },
                "Sí"
        );

        if (seleccionUsuario != -1) {
            switch (seleccionUsuario) {
                case 0:
                    conversorTemperatura();
                    break;
                case 1:
                    menuPrincipal();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Programa finalizado :D");
                    break;
            }
        } else {
            System.exit(0);
        }
    }

    /**
     * Al ser sólo dos items del menú comprobamos sólo si es o no la opción
     * Conversor de Moneda.
     *
     * @param seleccionUsuario
     * @return boolean - Devuelve valor boleano.
     */
    public static boolean esConversorMoneda(Object seleccionUsuario) {
        return seleccionUsuario.equals("Conversor de Moneda");
    }

    /**
     * Comprobando que el valor ingresado en el inputMessage sea numerico
     * decimal o entero.
     *
     * @param cantidadDivisaUsuario
     * @return
     */
    public static boolean esNumerico(double cantidadDivisaUsuario) {
        return JSType.isNumber(cantidadDivisaUsuario);
    }
}
