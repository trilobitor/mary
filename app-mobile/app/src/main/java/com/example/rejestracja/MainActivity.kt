package com.example.rejestracja

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * MainActivity - Glowna aktywnosc aplikacji Rejestracja konta
 * Egzamin INF.04 - Technik Programista
 *
 * Funkcjonalnosc:
 * - Formularz rejestracji z polami: email, haslo, powtorz haslo
 * - Walidacja adresu email (sprawdzenie znaku @)
 * - Walidacja zgodnosci hasel
 * - Wyswietlanie odpowiednich komunikatow
 */
class MainActivity : AppCompatActivity() {

    // Deklaracja pol - elementy interfejsu
    private lateinit var editEmail: EditText
    private lateinit var editHaslo: EditText
    private lateinit var editPowtorzHaslo: EditText
    private lateinit var buttonZatwierdz: Button
    private lateinit var textKomunikat: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicjalizacja elementow interfejsu
        editEmail = findViewById(R.id.editEmail)
        editHaslo = findViewById(R.id.editHaslo)
        editPowtorzHaslo = findViewById(R.id.editPowtorzHaslo)
        buttonZatwierdz = findViewById(R.id.buttonZatwierdz)
        textKomunikat = findViewById(R.id.textKomunikat)

        // Ustawienie poczatkowego komunikatu z numerem PESEL autora
        textKomunikat.text = "Autor 00000000000"

        // Obsluga klikniecia przycisku ZATWIERDZ
        buttonZatwierdz.setOnClickListener {
            zatwierdz()
        }
    }

    /**
     * Metoda obslugujaca zatwierdzenie formularza.
     * Sprawdza poprawnosc adresu email i zgodnosc hasel.
     */
    private fun zatwierdz() {
        // Pobranie wartosci z pol edycyjnych
        val email = editEmail.text.toString()
        val haslo = editHaslo.text.toString()
        val powtorzHaslo = editPowtorzHaslo.text.toString()

        // Sprawdzenie czy email zawiera znak @
        if (!email.contains("@")) {
            textKomunikat.text = "Nieprawidłowy adres e-mail"
            return
        }

        // Sprawdzenie czy hasla sa rowne
        if (haslo != powtorzHaslo) {
            textKomunikat.text = "Hasła się różnią"
            return
        }

        // Jesli nie ma bledow - wyswietlenie powitania
        textKomunikat.text = "Witaj $email"
    }
}
