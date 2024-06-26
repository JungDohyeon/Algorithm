let str = Array(readLine()!)
    
for value in Character("a").asciiValue!...Character("z").asciiValue! {
    var c = Character(UnicodeScalar(value))
    
    if str.contains(c){
        print("\(str.index(of: c)!)")
    } else {
        print("-1")
    }
}
