package br.com.softdesign.calcularviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import br.com.softdesign.calcularviagem.exception.PreencherTodosOsCapos
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        botaoCalcular.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val id = view.id
        if (id == R.id.botaoCalcular) {
            calculate()
        }
    }

    private fun calculate() {
        if (validationOK()) {
            try {
                val distancia = input_distancia.text.toString().toFloat()
                val preco = input_preco.text.toString().toFloat()
                val autonomia = input_autonomia.text.toString().toFloat()
                val relutado = (distancia * preco) / autonomia
                text_TotalValor.text = "R$ ${"%.2f".format(relutado)}"

            } catch (nfe: NumberFormatException) {
                Toast.makeText(this, getString(R.string.informar_valores_validos), Toast.LENGTH_LONG).show()
            }
        } else {
            Toast.makeText(this, getString(R.string.preenche_todos_campos), Toast.LENGTH_LONG).show()
        }
    }

    private fun validationOK(): Boolean {
        return input_distancia.text.toString() != ""
                && input_preco.text.toString() != ""
                && input_autonomia.text.toString() != ""
    }
}