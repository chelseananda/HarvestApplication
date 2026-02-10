🌱 Harvest Application

Harvest is an offline-first Android application built with Jetpack Compose that helps users manage gardens, plants, and gardening tasks through a clean and modern interface.

The project follows MVVM architecture and demonstrates best practices for state management, persistence, and UI composition in modern Android development.

✨ Features

🌿 Create and manage gardens

🪴 Track plants per garden

📅 Add and manage calendar events for gardening tasks

🗑 Delete events with undo support

💾 Offline persistence using Room

⚡ Reactive UI updates with StateFlow

🧠 Architecture

The app follows MVVM (Model–View–ViewModel) architecture:

UI (Jetpack Compose)
        ↓
ViewModel (StateFlow)
        ↓
Repository
        ↓
Room (DAO + Entities)


ViewModels expose UI state using StateFlow

Repositories abstract database access

Room handles persistence and relations between entities

🗄️ Data Modelling

GardenEntity → Parent entity

PlantEntity → Linked to Garden via foreign key

GardenEventEntity → Linked to Garden via foreign key

Room Relations are used to derive aggregate data, such as plant count per garden

🛠️ Tech Stack

Kotlin

Jetpack Compose

Room Database

StateFlow & Coroutines

Material 3

MVVM Architecture
