# PrakRSI

## Description

This repository contains the source code for the ResikinAE application, a system designed to manage user accounts and provide waste management information. It is developed as part of the Rekayasa Sistem Informasi course to provide hands-on experience with system engineering concepts and tools.

## Directories

- `src/`: Contains the source code for the project.
  - `main/`: Main source code directory.
    - `java/`: Java source files.
      - `Main.java`: Entry point for the application.
      - `com/`: Main package directory.
        - `controllers/`: Contains controller classes.
        - `models/`: Contains model classes.
        - `providers/`: Contains provider classes.
        - `ui/`: Contains UI classes.
    - `resources/`: Contains resource files.
      - `config`: Configuration files.
      - `images/`: Directory for image resources.

## Usage

To run the application, ensure you have Java Development Kit (JDK) installed (version 11 or higher), navigate to the project directory, compile the project using your preferred IDE or by running `javac -d bin src/main/java/com/**/*.java` in the terminal, and then run the application by executing the Main class with `java -cp bin src.main.java.Main`.

## Features

- **User Registration**: Allows new users to register by providing their details.
- **User Login**: Enables users to log in with their username and password.
- **Profile Management**: Users can view and edit their profile information.
- **Password Recovery**: Users can recover their password by providing their personal details.
- **Jadwal Pengambilan Sampah**: Users can view the schedule for garbage collection.
- **Tips and Trik**: Provides guidelines and tips regarding waste management.

## Contributing

We welcome contributions! To contribute, fork the repository, create a new branch, make your changes with descriptive commit messages, push to your fork, and open a pull request describing your changes.

## Code of Conduct

This project adheres to a Code of Conduct. By participating, you are expected to uphold this code. Please report unacceptable behavior to [reishash](https://github.com/reishash).

## License

This project is licensed under the MIT License - see the [LICENSE]() file for details.
