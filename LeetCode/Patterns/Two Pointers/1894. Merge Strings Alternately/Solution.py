class Solution(object):
    def mergeAlternately(self, word1, word2):
        word3 = ""
        i = 0

        while i < len(word1) and i < len(word2):
            word3 += word1[i]
            word3 += word2[i]
            i += 1

        word3 += word1[i:]
        word3 += word2[i:]

        return word3           