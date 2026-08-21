class Solution(object):
    def countNegatives(self, grid):
        count = 0

        for row in grid:
            for num in row:
                if num < 0:
                    count += 1

        return count     