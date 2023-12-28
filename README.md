
# Foodie Social Media Platform

Foodie Social Media Platform is a web application designed to connect food and beverage enthusiasts. Share your culinary experiences, follow other foodies, and engage in a vibrant community.

## Features

- **User Profiles:**
  - Each user has a public profile displaying their posts. Users can view their own profiles, explore suggestions, and search for other users.

- **Create and Edit Posts:**
  - Users can create posts with 1 to 4 photos and a description of their dining experiences. Posts can be edited or deleted later.

- **Follow Users:**
  - Connect with other users by following them. All profiles are public for easy discovery and connection.

- **Like and Comment:**
  - Users can like and comment on posts. The original comment author can edit or delete their comments.

- **Comment Management:**
  - The original post owner has the ability to delete any comments made on their posts.

- **Microservices Architecture:**
  - The middle-tier development of the Foodie Social Media Platform utilizes a microservices architecture.

    ```plaintext
    +---------------------+       +------------------------+       +----------------------+
    |       User          | <---  |       Post             | <---  |       Photo          |
    +---------------------+       +------------------------+       +----------------------+
            |                          |                            |
    +---------------------+       +------------------------+       +----------------------+
    |       Follow        |       |        Like            |       |      Comment         |
    +---------------------+       +------------------------+       +----------------------+
                                    |
                               +--------------------------+
                               |      Notification      |
                               +--------------------------+
    ```

- **Synchronous Communication with Spring RestTemplate:**
  - The microservices communicate synchronously using Spring RestTemplate. This allows for efficient communication between the services, enabling them to exchange data and perform actions seamlessly.

- **Real-time Notifications:**
  - Users receive notifications when others like or comment on their posts.

## Getting Started

1. **Clone the Repository:**
   ```bash
   git clone [repository-url]
   cd foodie-social-media-platform

