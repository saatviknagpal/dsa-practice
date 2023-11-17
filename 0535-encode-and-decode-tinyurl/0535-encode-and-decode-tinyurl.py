class Codec:
    def __init__(self):
        self.dic = []

    def encode(self, longUrl: str) -> str:
        """Encodes a URL to a shortened URL.
        """
        
        
        self.dic.append([longUrl, str(hash(longUrl))])
        return self.dic[0][1]
        

    def decode(self, shortUrl: str) -> str:
        """Decodes a shortened URL to its original URL.
        """
        
        return self.dic[0][0]
        

# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.decode(codec.encode(url))