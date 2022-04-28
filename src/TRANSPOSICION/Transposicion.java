/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TRANSPOSICION;

import java.net.Socket;

/**
 *
 * @author chris
 */
public class Transposicion {

    private Socket socket;

    public byte[] encripta(byte[] m) {
        int l = m.length;
        int n = (l / 2);

        byte[] c = new byte[l];

        int i = 0;
        int j = n + (l % 2);
        int k = 0;

        while (i < n) {
            c[k++] = m[i++];
            c[k++] = m[j++];
        }

        if (k < l) {
            c[k++] = m[i++];
        }

        return c;
    }

    public byte[] desencripta(byte[] c) {
        int l = c.length;
        int n = (l / 2);

        byte[] m = new byte[l];

        int i = 0;
        int j = n + (l % 2);
        int k = 0;

        while (i < n) {
            m[i++] = c[k++];
            m[j++] = c[k++];
        }

        if (k < l) {
            m[i++] = c[k++];
        }

        return m;
    }
}
