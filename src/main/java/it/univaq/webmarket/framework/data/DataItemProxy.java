/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.univaq.webmarket.framework.data;

/**
 *
 * @author abdrahimzeno
 */
public interface DataItemProxy {
    boolean isModified();

    void setModified(boolean dirty);
}
