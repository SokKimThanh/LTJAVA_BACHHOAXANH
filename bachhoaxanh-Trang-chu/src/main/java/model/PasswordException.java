/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ABC
 */
public class PasswordException extends Exception {

    public PasswordException() {
        System.out.println("Mật khẩu phải chứa ít nhất 8 ký tự");
    }

}
