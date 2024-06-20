document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault();

    var username = document.getElementById('username').value;
    var password = document.getElementById('password').value;

    fetch('/auth/sign-in', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            username: username,
            password: password
        })
    })
    .then(response => response.json())
    .then(data => {
        // Обработка ответа от сервера
        console.log(data);
        // Перенаправление на страницу пользователя или отображение сообщения об успешной авторизации
    })
    .catch(error => {
        console.error('Ошибка:', error);
        // Отображение сообщения об ошибке
    });
});

document.getElementById('registerForm').addEventListener('submit', function(event) {
    event.preventDefault();

    var username = document.getElementById('username').value;
    var email = document.getElementById('email').value;
    var password = document.getElementById('password').value;

    fetch('/auth/sign-up', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            username: username,
            email: email,
            password: password
        })
    })
    .then(response => response.json())
    .then(data => {
        // Обработка ответа от сервера
        console.log(data);
        // Перенаправление на страницу входа или отображение сообщения об успешной регистрации
    })
    .catch(error => {
        console.error('Ошибка:', error);
        // Отображение сообщения об ошибке
    });
});