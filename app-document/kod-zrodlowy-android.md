# APLIKACJA MOBILNA - KOD ZRODLOWY
## Egzamin INF.04 - Rejestracja konta

---

## INSTRUKCJA

1. Utworz nowy projekt w Android Studio:
   - **File → New → New Project → Empty Views Activity**
   - Name: `Rejestracja`
   - Package: `com.example.rejestracja`
   - Language: **Kotlin**
   - Minimum SDK: **API 24**

2. Zamien zawartosc dwoch plikow (ponizej)

---

## PLIK 1: activity_main.xml

**Sciezka:** `app/src/main/res/layout/activity_main.xml`

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Rejestruj konto"
        android:textSize="24sp"
        android:textColor="#FFFFFF"
        android:background="#008080"
        android:padding="16dp" />

    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Podaj e-mail:"
        android:layout_marginTop="16dp" />

    <EditText
        android:id="@+id/editEmail"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="email"
        android:inputType="textEmailAddress" />

    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Podaj hasło:"
        android:layout_marginTop="8dp" />

    <EditText
        android:id="@+id/editHaslo"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:inputType="textPassword" />

    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Powtórz hasło:"
        android:layout_marginTop="8dp" />

    <EditText
        android:id="@+id/editPowtorzHaslo"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:inputType="textPassword" />

    <Button
        android:id="@+id/buttonZatwierdz"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="ZATWIERDŹ"
        android:layout_gravity="center"
        android:layout_marginTop="24dp" />

    <TextView
        android:id="@+id/textKomunikat"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Autor 00000000000"
        android:gravity="center"
        android:layout_marginTop="16dp" />

</LinearLayout>
```

---

## PLIK 2: MainActivity.kt

**Sciezka:** `app/src/main/java/com/example/rejestracja/MainActivity.kt`

```kotlin
package com.example.rejestracja

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editEmail = findViewById<EditText>(R.id.editEmail)
        val editHaslo = findViewById<EditText>(R.id.editHaslo)
        val editPowtorzHaslo = findViewById<EditText>(R.id.editPowtorzHaslo)
        val buttonZatwierdz = findViewById<Button>(R.id.buttonZatwierdz)
        val textKomunikat = findViewById<TextView>(R.id.textKomunikat)

        textKomunikat.text = "Autor 00000000000"

        buttonZatwierdz.setOnClickListener {
            val email = editEmail.text.toString()
            val haslo = editHaslo.text.toString()
            val powtorzHaslo = editPowtorzHaslo.text.toString()

            if (!email.contains("@")) {
                textKomunikat.text = "Nieprawidłowy adres e-mail"
                return@setOnClickListener
            }

            if (haslo != powtorzHaslo) {
                textKomunikat.text = "Hasła się różnią"
                return@setOnClickListener
            }

            textKomunikat.text = "Witaj $email"
        }
    }
}
```

---

## URUCHOMIENIE

1. **Build → Make Project** (Ctrl+F9)
2. Wybierz emulator
3. Kliknij **Run** (Shift+F10)

---

## TESTOWANIE

| Test | Oczekiwany wynik |
|------|------------------|
| Email bez @ | "Nieprawidlowy adres e-mail" |
| Rozne hasla | "Hasla sie roznia" |
| Poprawne dane | "Witaj [email]" |
