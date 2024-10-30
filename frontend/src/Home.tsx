import { useState } from 'react'

function Home() {
  const [count,] = useState(1)

  return (
    <>
      <h3>Home {count}</h3>
    </>
  )
}

export default Home;
