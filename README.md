# Yuva Intern Week 2 — Library Book Inventory

This ZIP includes the required Java command-line application and an optional browser demo.

## Assignment requirements covered
- `Book` entity with ID, title, author, ISBN, publication year
- CRUD operations: add, list/read, update and delete
- In-memory storage using Java `ArrayList`
- Menu-driven command-line interface
- Validation for blank fields, invalid years, numeric input and duplicate ISBN
- Comments describing classes and logic
- README with compile/run steps

## Required Java application
The Java source files are in `java-src/`. They are compatible with Java 8 or newer.

Open a terminal in the extracted root folder and compile:

Windows:
```bat
javac -d out java-src\\Book.java java-src\\LibraryManager.java java-src\\Main.java
```

macOS/Linux:
```bash
javac -d out java-src/Book.java java-src/LibraryManager.java java-src/Main.java
```

Then run:
```bash
java -cp out Main
```

The assignment explicitly requests in-memory storage, so Java records disappear after the application exits.
