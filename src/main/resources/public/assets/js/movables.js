export const removeAllMovables = () => {
  const movables = document.querySelectorAll(".movable");
  movables.forEach(movable => {
    movable.parentElement.removeChild(movable);
  });
}

async function getMovables(point, roomId) {
  const response = await fetch("./" + roomId + "/movablePoints/" + point);
  return await response.json();
}

export const addMovables = (point, roomId) => {
  getMovables(point, roomId).then(movables => {
    for (const i in movables) {
      const square = document.querySelector(
          "#" + movables[i].x + movables[i].y);
      const moveDiv = document.createElement("div");
      moveDiv.classList.add("movable");
      moveDiv.value = point;
      square.insertAdjacentElement("afterbegin", moveDiv);
    }
  });
}