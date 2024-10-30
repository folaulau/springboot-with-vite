import { useState } from 'react'

function Signin() {
  const [count,] = useState(2)

  return (
    <>
      <h3>Sign In {count}</h3>
    </>
  )
}

export default Signin;
