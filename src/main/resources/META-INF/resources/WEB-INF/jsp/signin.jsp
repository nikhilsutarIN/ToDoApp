<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Sign In &#x00B7; Todo</title>
    <link rel="stylesheet" href="css/signin.css">
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
            <h1 id="signin-title" class="title">Welcome back</h1>
            <p class="subtitle">Sign in to manage your tasks</p>
        </header>

        <form action="/login" method="post">
            <div class="field">
                <label for="email">Email</label>
                <input id="email" name="username" type="email" inputmode="email" placeholder="you@example.com" required>
            </div>

            <div class="field">
                <label for="password">Password</label>
                <input id="password" name="password" type="password" placeholder="Your password" required>
            </div>

            <button type="submit" class="btn btn-primary submit">Sign in</button>
        </form>

        <p class="already">
            New here?
            <a href="/signup">Create an account</a>
        </p>
    </section>
</main>

<footer>
    <div class="container">&copy; 2025 Todo</div>
</footer>

</body>
</html>
