
    document.getElementById('register-form').addEventListener('submit', function(event) {
        // Prevent the form from being submitted normally
        event.preventDefault();
        // Use the Fetch API to make an AJAX request
        fetch(event.target.action, {
            method: 'POST',
            body: new FormData(event.target) // Create form data from form
        }).then(function(response) {
            // The server responds with a status and message
            return response.json();
        }).then(function(data) {
            // Get the notification placeholder
            var messageDiv = document.getElementById('message');
            // Set the message text
            messageDiv.textContent = data.message;
            // Add a class based on the status
            messageDiv.classList.add(data.status === 'success' ? 'alert-success' : 'alert-danger');
            // Show the message
            messageDiv.style.display = '';
        });
    });

