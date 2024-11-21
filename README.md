# PrakRSI

## Description

This repository contains practical assignments for the Rekayasa Sistem Informasi course. The assignments are designed to provide hands-on experience with system engineering concepts and tools.

## Directories

- `src/`: Contains the source code for the project.
  - `main/`: Main source code directory.
    - `java/`: Java source files.
      - `com/`: Main package directory.
        - `controllers/`: Contains controller classes.
        - `models/`: Contains model classes.
        - `providers/`: Contains provider classes.
        - `ui/`: Contains UI classes.
    - `resources/`: Contains resource files.
      - `applications.properties`: Configuration properties for the application.
      - `images/`: Directory for image resources.
- `Main.java`: Entry point for the application.

## Usage

To run the application, follow these steps:

1. Ensure you have Java Development Kit (JDK) installed (version 11 or higher).
2. Navigate to the project directory.
3. Compile the project using your preferred IDE or by running the following command in the terminal:

    ```sh
    javac -d bin src/main/java/com/**/*.java
    ```

4. Run the application by executing the Main class:

    ```sh
    java -cp bin src.main.java.Main
    ```

## Features

- **User Registration**: Allows new users to register by providing their details.
- **User Login**: Enables users to log in with their username and password.
- **Profile Management**: Users can view and edit their profile information.
- **Password Recovery**: Users can recover their password by providing their personal details.
- **Jadwal Pengambilan Sampah**: Users can view the schedule for garbage collection.
- **Tips and Trik**: Provides guidelines and tips regarding waste management.

## Contributing

We welcome contributions to this project! To contribute, please follow these guidelines:

1. Fork the repository.
2. Create a new branch for your feature or bugfix:

    ```sh
    git checkout -b feature/your-feature-name
    ```

3. Make your changes and commit them with descriptive messages:

    ```sh
    git commit -m "Add feature X"
    ```

4. Push your changes to your forked repository:

    ```sh
    git push origin feature/your-feature-name
    ```

5. Open a pull request and describe your changes in detail.

## Code of Conduct

This project adheres to a Code of Conduct. By participating, you are expected to uphold this code. Please report unacceptable behavior to [@reishash](github.com/reishash).

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
