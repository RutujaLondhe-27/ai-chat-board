window.onload = function() {

    fetch("http://localhost:8080/chat")
    .then(response => response.json())
    .then(data => {

        let chatBox = document.getElementById("chatBox");

        data.forEach(chat => {
			chatBox.innerHTML +=
			'<div class="user">' +
			chat.userMessage +
			'<br><small>' +
			chat.createdAt +
			'</small></div>';

			chatBox.innerHTML +=
			'<div class="ai">' +
			chat.aiResponse +
			'<br><small>' +
			chat.createdAt +
			'</small></div>';
        });

    });
}


function sendMessage(){

    let msg =
    document.getElementById("message").value;

    fetch(
        "http://localhost:8080/chat?message="
        + encodeURIComponent(msg),
        {
            method:"POST"
        }
    )
    .then(response => response.json())
    .then(data => {

        let chatBox =
        document.getElementById("chatBox");

		chatBox.innerHTML +=
		'<div class="user">' +
		data.userMessage +
		'<br><small>' +
		data.createdAt +
		'</small></div>';

		chatBox.innerHTML +=
		'<div class="ai">' +
		data.aiResponse +
		'<br><small>' +
		data.createdAt +
		'</small></div>';

        document.getElementById("message").value = "";
    });
}