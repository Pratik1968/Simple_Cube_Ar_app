package com.example.ar_tut

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.view.isGone

import io.github.sceneview.ar.ArSceneView
import io.github.sceneview.ar.node.ArModelNode
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    lateinit var sceneView : ArSceneView
    private lateinit var placebutton : Button
    lateinit var modelNode:ArModelNode
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sceneView = findViewById(R.id.sceneView)
        placebutton = findViewById(R.id.place)
        placebutton.setOnClickListener { place() }
        modelNode = ArModelNode().apply {
            loadModelGlbAsync(
                glbFileLocation = "cube.glb"
            )
            {
                sceneView.planeRenderer.isVisible =true
            }

                onAnchorChanged = {
                    placebutton.isGone
                }

        }
sceneView.addChild(modelNode)
    }

    private fun place() {

        print("here")
        modelNode?.anchor()
        sceneView.planeRenderer.isVisible =true
    }
}