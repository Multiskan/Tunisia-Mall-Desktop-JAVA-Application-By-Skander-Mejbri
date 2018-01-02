/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.esprit.infob3.pidev.GUI;

/**
 *
 * @author HP
 */
import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;

import javax.swing.*;
import java.awt.*;

public class World extends Frame{
    public static void main(String[] args) {
        Browser browser = new Browser();
        BrowserView browserView = new BrowserView(browser);

        JFrame frame = new JFrame("TnMall");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(browserView, BorderLayout.CENTER);
        frame.setSize(400, 300);
        frame.setVisible(true);

        browser.loadURL("http://www.samrohn.com/360-panorama/dior-boutique-manhattan");
    }
}