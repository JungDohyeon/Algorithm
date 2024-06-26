var arr = Set<Int>()

for _ in 0..<10 {
    let input = Int(readLine()!)!
    arr.insert(input % 42)
}

print(arr.count)