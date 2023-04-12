/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.project;

/**
 *
 * @author tonya
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Project {
    public static void main(String[] args) throws IOException {
        ProjectClass api = new ProjectClass();
        String response = api.fetchAverageSellingPrice();
        System.out.println(response);
    }
}
