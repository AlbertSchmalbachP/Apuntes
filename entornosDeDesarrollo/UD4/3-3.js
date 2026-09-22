//@ts-check

/**
 * runs through the array's values checking if any of them is equal to the desired name
 * @param {Array<{name: string}>} users 
 * @param {string} name 
 * @returns if the user was found, the function returns the name of the user. If not, it returns a null value
 */
function findUser(users, name) {
let result = null
for (let i = 0; i < users.length; i++) {
if (users[i].name === name) {
result = users[i]
}
}
return result
}