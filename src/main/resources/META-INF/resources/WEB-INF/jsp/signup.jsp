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


<%--<!DOCTYPE html>--%>
<%--<html lang="en">--%>
<%--<head>--%>
<%--    <meta charset="UTF-8">--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1.0">--%>
<%--    <title>Sign up</title>--%>
<%--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"--%>
<%--          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">--%>
<%--</head>--%>
<%--<body class="bg-light">--%>

<%--<section class="container mt-5" style="max-width: 30rem;">--%>
<%--    <div class="card p-3 shadow">--%>
<%--        <div class="card-body">--%>
<%--            <h3 class="card-title text-primary text-center mb-3">Sign up</h3>--%>
<%--            <form method="POST" action="/signup">--%>
<%--                <div class="row mb-3">--%>
<%--                    <div class="col-md-6">--%>
<%--                        <input class="form-control" type="text" name="firstname" placeholder="First name" required>--%>
<%--                    </div>--%>
<%--                    <div class="col-md-6">--%>
<%--                        <input class="form-control" type="text" name="lastname" placeholder="Last name" required>--%>
<%--                    </div>--%>
<%--                </div>--%>

<%--                <div class="row mb-3">--%>
<%--                    <div class="col-12">--%>
<%--                        <input class="form-control" type="email" name="email" placeholder="Email" required>--%>
<%--                    </div>--%>
<%--                </div>--%>

<%--                <div class="row mb-3">--%>
<%--                    <div class="col-12">--%>
<%--                        <input class="form-control" type="password" name="password" placeholder="Password" required>--%>
<%--                    </div>--%>
<%--                </div>--%>

<%--                <div class="row mb-3">--%>
<%--                    <div class="col-12">--%>
<%--                        <input class="btn btn-primary form-control" type="submit" value="Sign up">--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </form>--%>

<%--            <div class="row text-center">--%>
<%--                <p>Already have an account? <a href="/signin">Sign in</a></p>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</section>--%>

<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"--%>
<%--        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"--%>
<%--        crossorigin="anonymous"></script>--%>

<%--</body>--%>
<%--</html>--%>