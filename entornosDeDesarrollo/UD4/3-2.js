//@ts-check

/**
 * sums the values of the array in a "total" variable
 * 
 * @param {number[]} numbers ety6gr
 * @returns returns the average of the array's values
 */
function getAverage(numbers) {
if (numbers.length == 0) {
    prompt("The array doesn't have any values!")
}
let total = 0
for (let i = 0; i < numbers.length; i++) {
total += numbers[i]
}
return total / numbers.length
}