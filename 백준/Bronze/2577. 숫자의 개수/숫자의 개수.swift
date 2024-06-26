import Foundation

let A = Int(readLine()!)!
let B = Int(readLine()!)!
let C = Int(readLine()!)!

let mult = String(A * B * C)
var res = Array(repeating: 0, count: 10)

for i in mult {
   res[Int(String(i))!] += 1
}

print(res.map({String($0)}).joined(separator: "\n"))