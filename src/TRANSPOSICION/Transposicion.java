/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TRANSPOSICION;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
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

    public void sendBytes(byte[] myByteArray) throws IOException {
        sendBytes(myByteArray, 0, myByteArray.length);
    }

    public void sendBytes(byte[] myByteArray, int start, int len) throws IOException {
        if (len < 0) {
            throw new IllegalArgumentException("Negative length not allowed");
        }
        if (start < 0 || start >= myByteArray.length) {
            throw new IndexOutOfBoundsException("Out of bounds: " + start);
        }
        // Other checks if needed.

        // May be better to save the streams in the support class;
        // just like the socket variable.
        OutputStream out = socket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(out);

        dos.writeInt(len);
        if (len > 0) {
            dos.write(myByteArray, start, len);
        }
    }

}
