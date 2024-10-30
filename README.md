
---

# TodoGenie

### An intuitive and simple Android To-Do List Application

TodoGenie is a basic to-do list application built using Kotlin and Android. It helps users manage their tasks effectively by allowing them to add new tasks, mark them as done, and delete completed tasks. The app uses Android's RecyclerView to display the list of tasks and incorporates Kotlin coroutines for handling background operations like adding and deleting tasks.

## Features

- **Add Tasks**: Users can add a task by typing the title and clicking the "Add Todo" button.
- **Mark Tasks as Done**: Tasks can be marked as complete by checking the associated checkbox.
- **Delete Completed Tasks**: Completed tasks can be deleted with the "Delete Done" button.
- **Edge-to-Edge UI**: Designed to take advantage of Android's edge-to-edge system gestures for modern UI design.
- **Kotlin Coroutines**: Handles operations like task management using coroutines for better performance.

## Demonstartion 
https://github.com/user-attachments/assets/a2b378d3-d767-4c72-af93-da50d6ad47a3


## Installation and Setup

To clone and run this project, you'll need [Git](https://git-scm.com) and [Android Studio](https://developer.android.com/studio) installed on your computer.

1. Clone the repository:
   ```bash
   https://github.com/IsuruSankhajith/TodoGenie
   ```

2. Open the project in Android Studio.

3. Sync the Gradle project to install dependencies.

4. Run the app on an Android emulator or a physical device.

## Project Structure

```
TodoGenie/
│
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/todogenie/
│   │   │   │   ├── MainActivity.kt       # Main activity file
│   │   │   │   ├── Todo.kt               # Data class for todo items
│   │   │   │   ├── TodoAdapter.kt        # RecyclerView adapter
│   │   │   ├── res/
│   │   │   │   ├── layout/
│   │   │   │   │   ├── activity_main.xml # Main layout file
│   │   │   │   │   └── item_todo.xml     # Todo item layout
│   │   └── AndroidManifest.xml           # App configuration
├── gradle/
│   └── wrapper/
├── build.gradle
└── settings.gradle
```

## How It Works

- **Adding Tasks**: Users can type the task title into the input field and press the "Add Todo" button to add the task to the list. The tasks are displayed using a RecyclerView.
  
- **Marking Tasks as Done**: Each task has a checkbox to mark it as complete. When checked, the task title is strikethrough, indicating completion.

- **Deleting Tasks**: Completed tasks can be deleted using the "Delete Done" button. This is done by filtering out checked tasks from the list.

## Technologies Used

- **Kotlin**: The entire app is written in Kotlin.
- **RecyclerView**: Used to efficiently display and manage the list of todos.
- **Coroutines**: Kotlin coroutines are used for asynchronous operations like adding and deleting tasks.

## Issues and Considerations

- **Concurrency Issues**: Handling tasks with multiple threads needs careful consideration to avoid conflicts.
- **Edge-to-Edge Design Challenges**: UI adjustments for edge-to-edge layout may require further refinement on certain devices.

## Contribution

Feel free to fork this repository and submit pull requests. If you find any issues, please open an issue in the GitHub tracker.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---
