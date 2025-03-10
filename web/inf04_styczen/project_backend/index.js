const express = require('express')
const application = express()

var cors = require('cors');
application.use(cors());
application.use(express.json())

application.listen(8000, () => console.log('server started'));