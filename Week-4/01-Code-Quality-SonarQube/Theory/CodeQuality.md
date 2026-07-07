# Code Quality & SonarQube

## What is Code Quality?

Code quality means writing code that is easy to read, test, and maintain.
Good code doesn't just work - it should be understandable by other developers.

## Key Principles

**1. Clean Code**
- Use meaningful variable and method names
- Keep methods short and focused on one task
- Avoid duplicate code (DRY principle)
- Write self-explanatory code before adding comments

**2. Code Smells (bad signs)**
- Long methods (more than 20-30 lines) - split them up
- Magic numbers (`if (x > 42)`) - use named constants
- Dead code - remove code that is never called
- Duplicate logic - extract it into a shared method

**3. SOLID Principles**
- **S** - Single Responsibility: one class, one job
- **O** - Open/Closed: open for extension, closed for modification
- **L** - Liskov Substitution: subclass should work wherever parent class works
- **I** - Interface Segregation: don't force a class to implement methods it doesn't need
- **D** - Dependency Inversion: depend on abstractions, not concrete classes

## SonarQube

SonarQube is a tool that automatically scans your code and reports:
- **Bugs** - code that will probably cause an error
- **Vulnerabilities** - security issues
- **Code Smells** - things that make code hard to maintain
- **Coverage** - how much of your code is tested

### How to use SonarQube (local setup)
```bash
# 1. Start SonarQube server (via Docker)
docker run -d -p 9000:9000 sonarqube

# 2. Add sonar plugin to pom.xml
# 3. Run analysis
mvn sonar:sonar -Dsonar.host.url=http://localhost:9000
```

## Metrics to Watch

| Metric      | Goal              |
|-------------|-------------------|
| Test Coverage | > 80%           |
| Duplications  | < 5%            |
| Bugs          | 0               |
| Vulnerabilities | 0             |
| Code Smells   | As low as possible |
