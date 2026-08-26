package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

// Activité principale de l'application
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                LemonadeApp()
            }
        }
    }
}

// Composable principal contenant l'interface et la logique métier
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LemonAppWithButtonAndImage(modifier: Modifier = Modifier) {
    // État conservant l'étape actuelle du processus (1 à 4)
    var etape by remember { mutableIntStateOf(1) }

    // État conservant le nombre de clics restants pour presser le citron à l'étape 2
    var nbPression by remember { mutableIntStateOf(0) }

    // Détermination dynamique de l'image selon l'étape
    val imageResource = when (etape) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }

    // Détermination dynamique du texte explicatif selon l'étape
    val textResource = when (etape) {
        1 -> R.string.lemon_tree_to_select
        2 -> R.string.lemon_to_squeeze
        3 -> R.string.lemonade_to_drink
        else -> R.string.empty_glass_to_start
    }

    // Détermination de la description d'accessibilité selon l'étape
    val contentDescriptionResource = when (etape) {
        1 -> R.string.lemon_tree_content_description
        2 -> R.string.lemon_content_description
        3 -> R.string.lemonade_content_description
        else -> R.string.empty_glass_content_description
    }

    // Scaffold structure la mise en page avec une barre d'en-tête supérieure
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Lemonade",
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xFFFDE047)
                )
            )
        }
    ) { innerPadding ->
        // Conteneur alignant verticalement et horizontalement l'image et le texte
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // Bouton cliquable englobant l'image
            Button(
                onClick = {
                    when (etape) {
                        1 -> {
                            etape = 2
                            // Génère un nombre aléatoire de pressions requis entre 2 et 4
                            nbPression = (2..4).random()
                        }
                        2 -> {
                            nbPression--
                            // Passe à l'étape suivante uniquement lorsque le citron a été suffisamment pressé
                            if (nbPression == 0) {
                                etape = 3
                            }
                        }
                        3 -> etape = 4
                        4 -> etape = 1
                    }
                },
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFC3ECD2))
            ) {
                Image(
                    painter = painterResource(imageResource),
                    contentDescription = stringResource(contentDescriptionResource),
                    modifier = Modifier.padding(16.dp)
                )
            }

            // Espaceur vertical entre l'image et le texte
            Spacer(modifier = Modifier.height(16.dp))

            // Libellé explicatif d'instruction
            Text(
                text = stringResource(textResource),
                fontSize = 18.sp
            )
        }
    }
}

// Aperçu dans Android Studio
@Preview(showBackground = true)
@Composable
fun LemonadeApp() {
    LemonAppWithButtonAndImage()
}