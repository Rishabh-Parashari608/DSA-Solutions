class Solution(object):
    def reverseVowels(self, s):
        v = "aeiouAEIOU"
        c = [ch for ch in s if ch in v][::-1]

        res = ""
        i = 0

        for ch in s:
            if ch in v:
                res += c[i]
                i += 1
            else:
                res += ch

        return res

        
        