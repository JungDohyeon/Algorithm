import Foundation

let inputArr = readLine()!.split(separator: " ").map{ Int($0)! }

var H = inputArr[0]
var M = inputArr[1]

if M < 45 && M != 45 {
    if H == 0 {
        H = 23
    } else {
        H -= 1
    }
    
    M += 15
} else {
    M -= 45
}

print(String(H) + " " + String(M))