package co.edu.sena.peluqueriaalejandra

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class HistoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
    }

    fun onBack(view: View) {
        val intent = Intent(this, WelcomeActivity::class.java)
        startActivity(intent)
    }
}