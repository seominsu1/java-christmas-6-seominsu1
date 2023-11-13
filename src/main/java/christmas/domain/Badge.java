package christmas.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public enum Badge {
    STAR("별", 5000),
    TREE("트리", 10000),
    SANTA("산타", 20000),
    EMPTY("없음", 0);

    private String name;
    private int standardMoney;

    Badge(String name, int standardMoney) {
        this.name = name;
        this.standardMoney = standardMoney;
    }

    public static Badge findBadgeByAmount(int amount) {
        List<Badge> badges = Arrays.stream(Badge.values())
                .filter(type -> type.getStandardMoney() <= amount)
                .toList();
        return findWorthBadge(badges);
    }

    public int getStandardMoney() {
        return standardMoney;
    }

    public String getName() {
        return name;
    }

    public static Badge findWorthBadge(List<Badge> badges) {
        int maxPrice = 0;
        for (Badge badge : badges) {
            maxPrice = Math.max(badge.getStandardMoney(), maxPrice);
        }
        return findBadgeByStandardMoney(maxPrice);
    }

    public static Badge findBadgeByStandardMoney(int standardMoney) {
        Optional<Badge> findByStandardMoney = Arrays.stream(Badge.values()).
                filter(badge -> badge.getStandardMoney() == standardMoney)
                .findAny();
        return findByStandardMoney.get();
    }
}
