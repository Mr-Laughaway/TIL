const axios = require('axios')

axios.get('https://jsonplaceholder.typicode.com/posts/1')
.then(function(response){
  console.log(response.data.title)
})
.catch(err => {
  console.log(err)
})
