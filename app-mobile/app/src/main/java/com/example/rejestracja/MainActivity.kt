package com.example.rejestracja

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * MainActivity - Formularz rejestracji konta
 * Egzamin INF.04 - Technik Programista
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicjalizacja elementow interfejsu
        val editEmail = findViewById<EditText>(R.id.editEmail)
        val editHaslo = findViewById<EditText>(R.id.editHaslo)
        val editPowtorzHaslo = findViewById<EditText>(R.id.editPowtorzHaslo)
        val buttonZatwierdz = findViewById<Button>(R.id.buttonZatwierdz)
        val textKomunikat = findViewById<TextView>(R.id.textKomunikat)

        // Poczatkowy komunikat z numerem PESEL autora
        textKomunikat.text = "Autor 00000000000"

        // Obsluga klikniecia przycisku ZATWIERDZ
        buttonZatwierdz.setOnClickListener {
            val email = editEmail.text.toString()
            val haslo = editHaslo.text.toString()
            val powtorzHaslo = editPowtorzHaslo.text.toString()

            // Sprawdzenie czy email zawiera znak @
            if (!email.contains("@")) {
                textKomunikat.text = "Nieprawidłowy adres e-mail"
                return@setOnClickListener
            }

            // Sprawdzenie czy hasla sa rowne
            if (haslo != powtorzHaslo) {
                textKomunikat.text = "Hasła się różnią"
                return@setOnClickListener
            }

            // Sukces - wyswietlenie powitania
            textKomunikat.text = "Witaj $email"
        }
    }
}
