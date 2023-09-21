package com.example.mad_practical_6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val play:FloatingActionButton  = findViewById(R.id.play)
        var play_state = false
        play.setOnClickListener{
            if(!play_state){
                val playIntent = Intent(this, MusicService::class.java)
                playIntent.putExtra("MusicService", "Play")
                startService(playIntent)
                play.setImageResource(R.drawable.baseline_pause_circle_24)
                play_state = true
            }
            else{
                val playIntent = Intent(this, MusicService::class.java)
                playIntent.putExtra("MusicService", "Pause")
                startService(playIntent)
                play.setImageResource(R.drawable.play)
                play_state = false
            }
        }
    }
}