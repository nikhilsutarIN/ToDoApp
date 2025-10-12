<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Sign Up &#x00B7; Todo</title>
    <link rel="stylesheet" href="css/signup.css">
</head>
<body>
<header>
    <div class="brand"><a href="/">Todo</a></div>
    <nav class="navbar-actions">
        <a href="/signin" class="btn btn-ghost">Sign in</a>
        <a href="/signup" class="btn btn-primary">Sign up</a>
    </nav>
</header>

<main>
    <section class="card">
        <header>
            <h1 id="signup-title" class="title">Create your account</h1>
            <p class="subtitle">Sign up to start organizing your tasks</p>
        </header>

        <form action="/signup" method="post">
            <div class="name-row">
                <div class="field">
                    <label for="first-name">First name</label>
                    <input id="first-name" name="firstname" type="text" placeholder="Jane" required>
                </div>
                <div class="field">
                    <label for="last-name">Last name</label>
                    <input id="last-name" name="lastname" type="text" placeholder="Doe" required>
                </div>
            </div>

            <div class="field">
                <label for="email">Email</label>
                <input id="email" name="email" type="email" inputmode="email" placeholder="you@example.com" required>
            </div>

            <div class="field">
                <label for="password">Password</label>
                <input id="password" name="password" type="password" minlength="8" placeholder="At least 8 characters" required>
            </div>
            <button type="submit" class="btn btn-primary submit">Create account</button>
        </form>

        <p class="already">
            Already have an account?
            <a href="/signin">Sign in</a>
        </p>
    </section>
</main>

<footer>
    <div class="container">&copy; 2025 Todo</div>
</footer>

</body>
</html>
