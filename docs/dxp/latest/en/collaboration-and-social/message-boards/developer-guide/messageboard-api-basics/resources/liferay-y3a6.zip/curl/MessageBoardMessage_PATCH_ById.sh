curl \
	-H 'Content-Type: application/json' \
	-X 'PATCH' \
	"http://localhost:8080/o/headless-delivery/v1.0/message-board-messages/${1}" \
	-d "{\"articleBody\": \"Bar\"}" \
	-u "test@liferay.com:learn"