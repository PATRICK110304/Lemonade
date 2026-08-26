# Application Lemonade 🍋

**Lemonade** est une application Android interactive développée avec **Jetpack Compose** et **Kotlin**. Elle simule la préparation étape par étape d'une citronnade virtuelle au clic de l'utilisateur.

---

## 📱 Fonctionnalités

Le cycle de préparation se déroule en 4 étapes interactives :

1. **Sélection du citron** : L'utilisateur appuie sur le citronnier pour cueillir un citron.
2. **Pression du citron** : L'utilisateur doit appuyer plusieurs fois sur le citron pour le presser. Le nombre de clics requis est généré de manière aléatoire (entre 2 et 4 fois).
3. **Dégustation** : L'utilisateur appuie sur le verre de citronnade pour la boire.
4. **Recommencer** : L'utilisateur appuie sur le verre vide pour réinitialiser le cycle.

---

## 🛠️ Technologies & Outils

* **Langage** : Kotlin
* **Interface graphique** : Jetpack Compose (Material 3)
* **Architecture d'état** : `remember` & `mutableIntStateOf` pour la gestion réactive de l'interface
* **Layout** : `Scaffold`, `CenterAlignedTopAppBar`, `Column`, `Button`

---

## 🎨 Interface Visuelle

* **Barre d'en-tête (TopAppBar)** : Jaune (`#FDE047`) avec titre centré et en gras.
* **Boutons d'action** : Coins arrondis (`16.dp`) avec fond vert d'eau (`#C3ECD2`).
* **Typographie** : Texte d'instruction à `18.sp`.

---

## 🚀 Installation & Exécution

1. Clonez ce dépôt sur votre machine locale.
2. Ouvrez le projet dans **Android Studio**.
3. Assurez-vous d'avoir configuré un émulateur Android ou un appareil physique avec le débogage USB activé.
4. Cliquez sur **Run** (`Shift + F10`) pour compiler et lancer l'application.