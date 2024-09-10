
import React, { useState, useEffect } from 'react';
import axios from 'axios';

function App() {
    const [Blog, setBlogs] = useState('');

    useEffect(() => {
        axios.get('http://localhost:8080/blogs/dcvsd33')
            .then(response => {
                // Update the state with the response data
                setBlogs(response.data);
            })
            .catch(error => {
                console.error('There was an error fetching the data!', error);
            });
    }, []);

    if (!Blog) 
      return <div>Loading...</div>;

    return (
        <div>
            <h1>{Blog.title}</h1>
            <h1>{Blog.releaseDate}</h1>

        
        </div>
    );
}

export default App;
